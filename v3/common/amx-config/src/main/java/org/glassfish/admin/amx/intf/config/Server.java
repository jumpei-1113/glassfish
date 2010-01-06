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

package org.glassfish.admin.amx.intf.config;

import java.util.Map;
import org.glassfish.admin.amx.core.AMXProxy;

import org.glassfish.admin.amx.intf.config.grizzly.NetworkConfig;


/**
Base interface for server configuration for the &lt;server&gt; element.
Does not provide ability to access resource or application-ref; see
{@link StandaloneServerConfig} and {@link ClusteredServerConfig}.
 */
public interface Server
        extends PropertiesAccess, SystemPropertiesAccess, NamedConfigElement
{
    public NetworkConfig getNetworkConfig();

    /**
    Get the name of the config element referenced by this server.
    @since Glassfish V3
     */
    public String getConfigRef();

    /**
    Get the name of the node-agent element referenced by this server.
    @since Glassfish V3
     */
    public String getNodeAgentRef();

    public Map<String, ApplicationRef> getApplicationRef();

   
    public Map<String, ResourceRef> getResourceRef();

    /**
    <b>EE only</b>
    Return the load balancer weight for this server.
    This is used by both IIOP and HTTP load balancer. Default value is 1.
    @since AppServer 9.0
     */
    
    public String getLbWeight();

    /**
    <b>EE only</b>
    Set the load balancer weight for this server to the specified value.
    @since AppServer 9.0
     */
    public void setLbWeight(final String weight);
}
