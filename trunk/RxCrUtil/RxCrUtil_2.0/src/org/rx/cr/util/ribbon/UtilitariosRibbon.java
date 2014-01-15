package org.rx.cr.util.ribbon;

import java.awt.Dimension;
import org.pushingpixels.flamingo.api.common.icon.ImageWrapperResizableIcon;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;
import org.pushingpixels.flamingo.api.ribbon.JRibbonFrame;
import static org.rx.cr.util.Utilitarios.getIconFromResource;

public class UtilitariosRibbon {
    public static void setIconoVentana(JRibbonFrame vent,String resourcePath){          
          vent.setIconImage(getIconFromResource(resourcePath).getImage());
          vent.setApplicationIcon(getResizableIconFromResource(resourcePath));
    }    
    public static ResizableIcon getResizableIconFromResource(String resource) {      
        return getResizableIconFromResource(resource,48,48);
    }
    public static ResizableIcon getResizableIconFromResource(String resource,int size) {      
        return getResizableIconFromResource(resource,size,size);
    }
    public static ResizableIcon getResizableIconFromResource(String resource,int width,int height) {      
        return ImageWrapperResizableIcon.getIcon(Class.class.getClass().getResourceAsStream(resource),new Dimension(width,height));
    }
}
