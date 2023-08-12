package io.bayrktlihn.vakifbank.client.vakifbank.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class ResultDetailDto {

    @XmlElement(name = "ErrorCode")
    private String errorCode;
    @XmlElement(name = "ErrorMessage")
    private String errorMessage;

}
