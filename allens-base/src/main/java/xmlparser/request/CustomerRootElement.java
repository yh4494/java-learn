package xmlparser.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Customer")
@Data
public class CustomerRootElement {

    private Body Body;

    private Header Header;

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class Header {
        private String Description;
        private String EDIID;
        private String SentDateTime;
        private String SentFrom;
        private String SentTo;

        public Header(String description, String ediid, String sentDateTime, String sentFrom, String sentTo) {
            Description  = description;
            EDIID        = ediid;
            SentDateTime = sentDateTime;
            SentFrom     = sentFrom;
            SentTo       = sentTo;
        }
    }

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class Body {
        private CusDetail CusDetail;
        public Body(CusDetail createCrmCustomers) {
            this.CusDetail = createCrmCustomers;
        }
    }

    public CustomerRootElement(CusDetail createCrmCustomers, String description, String ediid, String sentDateTime, String sentFrom, String sentTo) {
        Body   = new Body(createCrmCustomers);
        Header = new Header(description, ediid, sentDateTime, sentFrom, sentTo);
    }

    public CustomerRootElement() {
    }
}
