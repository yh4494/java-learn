package http;

import com.alibaba.fastjson.JSON;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.IdleConnectionEvictor;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import xmlparser.request.CusDetail;
import xmlparser.request.CustomerRootElement;
import xmlparser.utils.XMLUtil;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author allens
 * @date   2019.05.21
 */
public class HttpHelper {

    private PoolingHttpClientConnectionManager poolingHttpClientConnectionManager;

    // http连接池总数
    private Integer httpPoolMaxTotalSize = 200;

    private Integer httpPoolRouteSize = 20;

    public HttpHelper() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(httpPoolMaxTotalSize);
        cm.setDefaultMaxPerRoute(httpPoolRouteSize);
        this.poolingHttpClientConnectionManager = cm;
    }

    /**
     * 公共配置
     * @return
     */
    private RequestConfig requestConfig() {
        RequestConfig.Builder builder = RequestConfig.custom();
        // 设置创建连接的最长时间，单位是毫秒
        builder.setConnectTimeout(2000);
        // 设置从连接池获取连接的最长时间，单位是毫秒
        builder.setConnectionRequestTimeout(500);
        builder.setSocketTimeout(10 * 1000);
        return builder.build();
    }

    /**
     * 关闭进程池
     */
    public void destory() {
        this.poolingHttpClientConnectionManager.close();
    }

    public void init() {
        new IdleConnectionEvictor(this.getPoolingHttpClientConnectionManager()).start();
    }

    /**
     * doGet
     * @param url 请求地址
     * @throws Exception
     */
    public String doGet(String url, HashMap<String, String> header) throws Exception {
        //从连接池中获取client对象，多例
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setRetryHandler(retryHandler(5)).build();
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-type", "application/json");
        if (header != null) {
            header.forEach(httpGet::setHeader);
        }
        // 设置请求配置信息
        httpGet.setConfig(this.requestConfig());
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return content;
            } else {
                return null;
            }
        } finally {
            if (response != null) {
                response.close();
            }
            // 此处不能关闭httpClient，如果关闭httpClient，连接池也会销毁
            // httpClient.close();
        }
    }

    /**
     * post请求
     *
     * @param urlPath
     * @param params
     * @return
     */
    public String doPost(String urlPath, Object params, Map<String, String> header) {

        String resultString = null;
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setRetryHandler(retryHandler(5)).build();
        HttpPost httpPost = new HttpPost(urlPath);
        try {
            httpPost.setHeader("Content-type", "application/json");
            System.out.println(JSON.toJSONString(params));
            StringEntity reqEntity = new StringEntity(JSON.toJSONString(params), "UTF-8");        //用StringEntity对象包装请求体数据
            httpPost.setEntity(reqEntity);
            if (header != null) {
                header.forEach(httpPost::setHeader);
            }
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            resultString = EntityUtils.toString(httpEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    /**
     * 请求NC封装
     * @param urlPath
     * @param params
     * @param header
     * @return
     */
    public String doPostNC(String urlPath, String params, Map<String, String> header){
        String resultString = null ;
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setRetryHandler(retryHandler(5)).build();
        HttpPost httpPost = new HttpPost(urlPath);
        try {
            httpPost.setHeader("Content-type", "application/xml");
            StringEntity reqEntity = new StringEntity(params, "UTF-8");      //用StringEntity对象包装请求体数据
            httpPost.setEntity(reqEntity);
            if (header != null) {
                header.forEach(httpPost::setHeader);
            }
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            resultString = EntityUtils.toString(httpEntity);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString ;
    }

    public PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager() {
        return poolingHttpClientConnectionManager;
    }

    /**
     * 请求重试处理
     * @param tryTimes 重试次数
     * @return
     */
    public static HttpRequestRetryHandler retryHandler(final int tryTimes){

        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                // 如果已经重试了n次，就放弃
                if (executionCount >= tryTimes) {
                    return false;
                }
                // 如果服务器丢掉了连接，那么就重试
                if (exception instanceof NoHttpResponseException) {
                    return true;
                }
                // 不要重试SSL握手异常
                if (exception instanceof SSLHandshakeException) {
                    return false;
                }
                // 超时
                if (exception instanceof InterruptedIOException) {
                    return false;
                }
                // 目标服务器不可达
                if (exception instanceof UnknownHostException) {
                    return true;
                }
                // 连接被拒绝
                if (exception instanceof ConnectTimeoutException) {
                    return false;
                }
                // SSL握手异常
                if (exception instanceof SSLException) {
                    return false;
                }
                HttpClientContext clientContext = HttpClientContext .adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };
        return httpRequestRetryHandler;
    }

    public static void testPost() {
        HttpHelper httpHelper        = new HttpHelper();
        String url                   = "http://116.246.19.244:12018/EAI/Receive/postFile/134";
        HashMap<String, String> hs   = new HashMap<>();
        hs.put("Content-type", "application/xml");
        CusDetail createCrmCustomers = new CusDetail(
                "CN", "票结", "宁波总部一号", "完美客商", "PERFACT", "1111111",
                "22222", "直客", "12345678", "111111122");
        CustomerRootElement customerRootElement = new CustomerRootElement(createCrmCustomers, "123", "456", "789", "11111", "11111");

        // 将对象转换成string类型的xml
        String data = XMLUtil.convertToXml(customerRootElement);
        String temp = data.replace(" standalone=\"yes\"", "");
        System.out.println(temp);
        // hs.put("signature", SigntureUtils.cryptToken(params, apiSecret, appid));
        String res = httpHelper.doPostNC(url, temp, hs);
        System.out.println(res);
    }

    public static void testXmlRequest () {
        HttpHelper httpHelper = new HttpHelper();
        try {
            //发起3次GET请求
            String url       = "https://api.mch.weixin.qq.com/pay/unifiedorder";
            HashMap<String, String> hs = new HashMap<>();
            Map params = new HashMap();
            hs.put("Content-type", "application/xml");
//            String res = httpHelper.doPost(url, hs);
//            long end = System.currentTimeMillis();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws Exception {
        testPost();
    }

    /**
     * 监听连接池中空闲连接，清理无效连接
     */
    public static class IdleConnectionEvictor extends Thread {

        private final HttpClientConnectionManager connectionManager;

        private volatile boolean shutdown;

        public IdleConnectionEvictor(HttpClientConnectionManager connectionManager) {
            this.connectionManager = connectionManager;
        }

        @Override
        public void run() {
            try {
                while (!shutdown) {
                    synchronized (this) {
                        // 3s检查一次
                        wait(3000);
                        // 关闭失效的连接
                        connectionManager.closeExpiredConnections();
                    }
                }
            } catch (InterruptedException ex) {
                // 结束
                ex.printStackTrace();
            }
        }

        public void shutdown() {
            shutdown = true;
            synchronized (this) {
                notifyAll();
            }
        }
    }
}
