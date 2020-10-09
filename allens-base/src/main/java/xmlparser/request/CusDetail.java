package xmlparser.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CusDetail")
@XmlType(propOrder = {
    "BLAddress",
    "ContainerCode",
    "Country",
    "CreditType",
    "CustAddress",
    "CustCNName",
    "CustENAddress",
    "CustENName",
    "EmailInvoiceAddress",
    "Fax",
    "InvoiceHead",
    "EmailInvoiceAddr",
    "SalesMan",
    "SendDocAddress",
    "TaxpayerIdNumber",
    "Tel",
    "TrustCustType",
    "CustApplyRole",
    "EnterpriseRegCode"
})
@Data
public class CusDetail {

    //
    private String BLAddress;

    // 集装箱编码
    private String ContainerCode;

    // 国家 required
    private String Country;

    // 信控方式
    private String CreditType;

    // 客户地址
    private String CustAddress;

    // 客户中文名称 required
    private String CustCNName;

    // 客户英文地址
    private String CustENAddress;

    // 客户英文名称 required
    private String CustENName;

    private String EmailInvoiceAddress;

    // 传真
    private String Fax;

    // 开票抬头
    private String InvoiceHead;

    // 寄发票地址
    private String EmailInvoiceAddr;

    // 销售 required
    private String SalesMan;

    private String SendDocAddress;

    private String TaxpayerIdNumber;

    // 电话
    private String Tel;

    private String TrustCustType;

    // 客户角色 required
    private String CustApplyRole;

    // 纳税人识别号
    private String EnterpriseRegCode;

    public  CusDetail(String country, String creditType, String custAddress, String custCNName, String custENName, String fax, String tel, String custApplyRole, String enterpriseRegCode, String SalesMan) {
        Country = country;
        CreditType = creditType;
        CustAddress = custAddress;
        CustCNName = custCNName;
        CustENName = custENName;
        Fax = fax;
        Tel = tel;
        CustApplyRole = custApplyRole;
        EnterpriseRegCode = enterpriseRegCode;
    }

    public CusDetail() {
    }
}
