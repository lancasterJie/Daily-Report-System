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
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.styledxmlparser.css.util.CssUtils;
import com.itextpdf.styledxmlparser.resolver.resource.ResourceResolver;
import com.itextpdf.svg.SvgConstants;
import com.itextpdf.svg.renderers.ISvgNodeRenderer;
import com.itextpdf.svg.renderers.SvgDrawContext;


/**
 * Responsible for drawing Images to the canvas.
 * Referenced SVG images aren't supported yet. TODO RND-984
 */
public class ImageSvgNodeRenderer extends AbstractSvgNodeRenderer {

    @Override
    protected void doDraw(SvgDrawContext context) {
        ResourceResolver resourceResolver = context.getResourceResolver();

        if ( resourceResolver != null && this.attributesAndStyles != null ) {
            PdfImageXObject xObject = resourceResolver.retrieveImage(this.attributesAndStyles.get(SvgConstants.Attributes.XLINK_HREF));

            if (xObject != null) {
                PdfCanvas currentCanvas = context.getCurrentCanvas();

                float x = 0;
                float y = 0;

                if (attributesAndStyles.containsKey(SvgConstants.Attributes.X)) {
                    x = CssUtils.parseAbsoluteLength(attributesAndStyles.get(SvgConstants.Attributes.X));
                }

                if (attributesAndStyles.containsKey(SvgConstants.Attributes.Y)) {
                    y = CssUtils.parseAbsoluteLength(attributesAndStyles.get(SvgConstants.Attributes.Y));
                }

                float width = 0;

                if (attributesAndStyles.containsKey(SvgConstants.Attributes.WIDTH)) {
                    width = CssUtils.parseAbsoluteLength(attributesAndStyles.get(SvgConstants.Attributes.WIDTH));
                }

                float height = 0;

                if (attributesAndStyles.containsKey(SvgConstants.Attributes.HEIGHT)) {
                    height = CssUtils.parseAbsoluteLength(attributesAndStyles.get(SvgConstants.Attributes.HEIGHT));
                }

                if (attributesAndStyles.containsKey(SvgConstants.Attributes.PRESERVE_ASPECT_RATIO)) {
                    // TODO RND-876
                }

                float v = y + height;

                currentCanvas.addXObject(xObject, width, 0, 0, -height, x, v);
            }
        }
    }

    @Override
    public ISvgNodeRenderer createDeepCopy() {
        ImageSvgNodeRenderer copy = new ImageSvgNodeRenderer();
        deepCopyAttributesAndStyles(copy);
        return copy;
    }
}