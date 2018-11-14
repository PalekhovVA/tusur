package ru.tusur.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageDto {

    private int maxX;

    private int maxY;

    private List<PixelDto> pixelDtoList;

}
