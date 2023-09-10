package com.bastex.codelearninghub.designpatterns.creational.prototype;


import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class GraphicTool {
    @Setter
    private Graphic prototype;

    protected Graphic createGraphic() {
        return prototype.clone();
    }
}
