package io.bayrktlihn.vakifbank.client.vakifbank.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@XmlRootElement(name = "IPaySecure")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class IPaySecureDto implements Serializable {


    @XmlElement(name = "Message")
    private MessageDto message;

    @XmlElement(name = "VerifyEnrollmentRequestId")
    private String verifyEnrollmentRequestId;

    @XmlElement(name = "MessageErrorCode")
    private String messageErrorCode;

    @XmlElement(name = "ErrorMessage")
    private String errorMessage;

    @XmlElement(name = "ResultDetail")
    private ResultDetailDto resultDetail;


    @XmlElement(name = "VERes")
    private VEResDto veRes;


}