/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2018 iText Group NV
    Authors: iText Software.

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License version 3
    as published by the Free Software Foundation with the addition of the
    following permission added to Section 15 as permitted in Section 7(a):
    FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY
    ITEXT GROUP. ITEXT GROUP DISCLAIMS THE WARRANTY OF NON INFRINGEMENT
    OF THIRD PARTY RIGHTS

    This program is distributed in the hope that it will be useful, but
    WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
    or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU Affero General Public License for more details.
    You should have received a copy of the GNU Affero General Public License
    along with this program; if not, see http://www.gnu.org/licenses or write to
    the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
    Boston, MA, 02110-1301 USA, or download the license from the following URL:
    http://itextpdf.com/terms-of-use/

    The interactive user interfaces in modified source and object code versions
    of this program must display Appropriate Legal Notices, as required under
    Section 5 of the GNU Affero General Public License.

    In accordance with Section 7(b) of the GNU Affero General Public License,
    a covered work must retain the producer line in every PDF that is created
    or manipulated using iText.

    You can be released from the requirements of the license by purchasing
    a commercial license. Buying such a license is mandatory as soon as you
    develop commercial activities involving the iText software without
    disclosing the source code of your own applications.
    These activities include: offering paid services to customers as an ASP,
    serving PDFs on the fly in a web application, shipping iText with a closed
    source product.

    For more information, please contact iText Software Corp. at this
    address: sales@itextpdf.com
 */
package com.itextpdf.svg.renderers.impl;

import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.styledxmlparser.css.util.CssUtils;
import com.itextpdf.svg.SvgConstants;
import com.itextpdf.svg.renderers.ISvgNodeRenderer;
import com.itextpdf.svg.renderers.SvgDrawContext;
import com.itextpdf.svg.utils.DrawUtils;

/**
 * {@link ISvgNodeRenderer} implementation for the &lt;circle&gt; tag.
 */
public class EllipseSvgNodeRenderer extends AbstractSvgNodeRenderer {

    float cx, cy, rx, ry;

    @Override
    protected void doDraw(SvgDrawContext context) {
        PdfCanvas cv = context.getCurrentCanvas();
        cv.writeLiteral("% ellipse\n");
        if(setParameters()) {
            cv.moveTo(cx + rx, cy);
            DrawUtils.arc(cx - rx, cy - ry, cx + rx, cy + ry, 0, 360, cv);
        }
    }

    /**
     * Fetches a map of String values by calling getAttribute(Strng s) method
     * and maps it's values to arc parmateter cx, cy , rx, ry respectively
     * @return boolean values to indicate whether all values exit or not
     */
    protected boolean setParameters(){
        cx=0; cy=0;
        if(getAttribute(SvgConstants.Attributes.CX) != null){
            cx = CssUtils.parseAbsoluteLength(getAttribute(SvgConstants.Attributes.CX));
        }
        if(getAttribute(SvgConstants.Attributes.CY) != null){
            cy = CssUtils.parseAbsoluteLength(getAttribute(SvgConstants.Attributes.CY));
        }

        if(getAttribute(SvgConstants.Attributes.RX) != null
                && CssUtils.parseAbsoluteLength(getAttribute(SvgConstants.Attributes.RX)) >0){
            rx = CssUtils.parseAbsoluteLength(getAttribute(SvgConstants.Attributes.RX));
        }else{
            return false; //No drawing if rx is absent
        }
        if(getAttribute(SvgConstants.Attributes.RY) != null
                &&CssUtils.parseAbsoluteLength(getAttribute(SvgConstants.Attributes.RY)) >0){
            ry = CssUtils.parseAbsoluteLength(getAttribute(SvgConstants.Attributes.RY));
        }else{
            return false; //No drawing if ry is absent
        }
        return true;
    }

    @Override
    public ISvgNodeRenderer createDeepCopy() {
        EllipseSvgNodeRenderer copy = new EllipseSvgNodeRenderer();
        deepCopyAttributesAndStyles(copy);
        return copy;
    }



}
