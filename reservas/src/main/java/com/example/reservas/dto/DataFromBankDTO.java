package com.example.reservas.dto;
import lombok.Data;

import java.util.List;
@Data
public class DataFromBankDTO {
    private List<DataFromBankDetailDTO> banks;
}
