/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2018 iText Group NV
    Authors: Bruno Lowagie, Paulo Soares, et al.
    
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
package com.itextpdf.styledxmlparser.css.resolve;

import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Helper class that allows you to check if a property is inheritable.
 */
public class CssInheritance implements IStyleInheritance {

    /**
     * Set of inheritable properties
     * in accordance with "http://www.w3schools.com/cssref/"
     * and "https://developer.mozilla.org/en-US/docs/Web/CSS/Reference"
     */
    private static final Set<String> inheritableProperties = new HashSet<>(Arrays.asList(

            // Color Properties
            CommonCssConstants.COLOR,

            // Basic Box Properties
            CommonCssConstants.VISIBILITY,

            // Text Properties
            CommonCssConstants.HANGING_PUNCTUATION,
            CommonCssConstants.HYPHENS,
            CommonCssConstants.LETTER_SPACING,
            CommonCssConstants.LINE_HEIGHT,
            CommonCssConstants.OVERFLOW_WRAP,
            CommonCssConstants.TAB_SIZE,
            CommonCssConstants.TEXT_ALIGN,
            CommonCssConstants.TEXT_ALIGN_LAST,
            CommonCssConstants.TEXT_INDENT,
            CommonCssConstants.TEXT_JUSTIFY,
            CommonCssConstants.TEXT_TRANSFORM,
            CommonCssConstants.WHITE_SPACE,
            CommonCssConstants.WORD_BREAK,
            CommonCssConstants.WORD_SPACING,
            CommonCssConstants.WORDWRAP,

            // Text Decoration Properties
            CommonCssConstants.TEXT_SHADOW,
            CommonCssConstants.TEXT_UNDERLINE_POSITION,

            // Font Properties
            CommonCssConstants.FONT,
            CommonCssConstants.FONT_FAMILY,
            CommonCssConstants.FONT_FEATURE_SETTINGS,
            CommonCssConstants.FONT_KERNING,
            CommonCssConstants.FONT_LANGUAGE_OVERRIDE,
            CommonCssConstants.FONT_SIZE,
            CommonCssConstants.FONT_SIZE_ADJUST,
            CommonCssConstants.FONT_STRETCH,
            CommonCssConstants.FONT_STYLE,
            CommonCssConstants.FONT_SYNTHESIS,
            CommonCssConstants.FONT_VARIANT,
            CommonCssConstants.FONT_VARIANT_ALTERNATES,
            CommonCssConstants.FONT_VARIANT_CAPS,
            CommonCssConstants.FONT_VARIANT_EAST_ASIAN,
            CommonCssConstants.FONT_VARIANT_LIGATURES,
            CommonCssConstants.FONT_VARIANT_NUMERIC,
            CommonCssConstants.FONT_VARIANT_POSITION,
            CommonCssConstants.FONT_WEIGHT,

            // Writing Modes Properties
            CommonCssConstants.DIRECTION,
            CommonCssConstants.TEXT_ORIENTATION,
            CommonCssConstants.TEXT_COMBINE_UPRIGHT,
            CommonCssConstants.UNICODE_BIDI,
            CommonCssConstants.WRITING_MODE,

            // Table Properties
            CommonCssConstants.BORDER_COLLAPSE,
            CommonCssConstants.BORDER_SPACING,
            CommonCssConstants.CAPTION_SIDE,
            CommonCssConstants.EMPTY_CELLS,

            // Lists and Counters Properties
            CommonCssConstants.LIST_STYLE,
            CommonCssConstants.LIST_STYLE_IMAGE,
            CommonCssConstants.LIST_STYLE_POSITION,
            CommonCssConstants.LIST_STYLE_TYPE,

            // Generated Content for Paged Media
            CommonCssConstants.QUOTES
    ));

    /**
     * Checks if a property is inheritable.
     *
     * @param cssProperty the CSS property
     * @return true, if the property is inheritable
     */
    @Override
    public boolean isInheritable(String cssProperty) {
        return inheritableProperties.contains(cssProperty);
    }
}
