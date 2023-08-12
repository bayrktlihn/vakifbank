package io.bayrktlihn.vakifbank.client.vakifbank.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class VEResDto implements Serializable {
    @XmlElement(name = "Version")
    private String version;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "PaReq")
    private String paReq;

    @XmlElement(name = "ACSUrl")
    private String acsUrl;

    @XmlElement(name = "TermUrl")
    private String termUrl;

    @XmlElement(name = "MD")
    private String md;

    @XmlElement(name = "ACTUALBRAND")
    private String actualBrand;
}
