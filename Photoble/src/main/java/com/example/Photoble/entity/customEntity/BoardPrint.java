package com.example.Photoble.entity.customEntity;

import com.example.Photoble.entity.BoardImage;
import lombok.Data;

import java.util.List;

@Data
public class BoardPrint {
    private Integer id;

    private String title;

    private String user;

    private String date;

    private List<ImageTagPrint> imageTagPrintList;

}
