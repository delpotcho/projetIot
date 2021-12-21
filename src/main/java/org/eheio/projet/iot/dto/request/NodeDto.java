package org.eheio.projet.iot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor @NoArgsConstructor
public class NodeDto {
    private Float temperature ;
    private Float humedity ;
    private Date date ;
}
