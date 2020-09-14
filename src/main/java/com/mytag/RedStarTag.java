package com.mytag;

import javax.servlet.jsp.*;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;

public class RedStarTag extends SimpleTagSupport{
        public void doTag() throws JspException, IOException{
            JspWriter out = getJspContext().getOut();
            out.print("<font color ='#FF0000'>*</font>");
        }
    }

