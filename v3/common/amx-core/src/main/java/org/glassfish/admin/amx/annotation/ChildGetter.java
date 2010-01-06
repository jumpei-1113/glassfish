/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2009 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package org.glassfish.admin.amx.annotation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;


import org.glassfish.external.arc.Taxonomy;
import org.glassfish.external.arc.Stability;


/**
    Used on an AMXProxy sub-interface only.  Indicates that the method
    is a proxy-based method for getting a child or List/Set/Map of children;
    <em>it doesn’t actually exist as an MBean attribute or method</em>.  This annotation
    should not be applied when the method or Attribute actually does exist. This
    annotation is generally needed only when there are arbitrary types of children that
    are not known in advance and/or methods do not exist for them (eg because of derivation
    such as with config MBeans).
    <p>
    The proxy method to which the annotation is applied must be of one of the following forms,
    where the interface FooBar is a sub-interface of {@link org.glassfish.admin.amx.core.AMXProxy}.
    <code>
    <ul>
    <li>FooBar           getFooBar();        // gets a singleton child </li>
    <li>Set&lt;FooBar>   getFooBar();        // gets all FooBar </li>
    <li>List&lt;FooBar>  getFooBar();        // gets all FooBar </li>
    <li>Map&lt;String,FooBar>  getFooBar();  // gets all FooBar </li>
    <li>FooBar[]         getFooBar();        // gets all FooBar </li>
    </ul>
    </code>
    The child type is derived from the method name, but if the standard derivation would result
    in the incorrect type then the annotation must include <code>type="child-type"></code>, where
    "child-type" is the appropriate type.
   @author Lloyd Chambers
 */
@Retention(RUNTIME)
@Documented
@Target({METHOD})
@Taxonomy(stability = Stability.NOT_AN_INTERFACE)
public @interface ChildGetter {
    /** child type, derived automatically by default for the normal naming pattern */
    String type() default "";
}







