/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.xml.wsdl.model.extensions.soap12.impl;

import java.util.Collection;
import org.netbeans.modules.xml.wsdl.model.BindingInput;
import org.netbeans.modules.xml.wsdl.model.BindingOutput;
import org.netbeans.modules.xml.wsdl.model.WSDLModel;
import org.netbeans.modules.xml.wsdl.model.extensions.soap12.SOAP12Component;
import org.netbeans.modules.xml.wsdl.model.extensions.soap12.SOAP12Header;
import org.netbeans.modules.xml.wsdl.model.extensions.soap12.SOAP12HeaderFault;
import org.netbeans.modules.xml.wsdl.model.extensions.soap12.SOAP12QName;
import org.netbeans.modules.xml.xam.Component;
import org.w3c.dom.Element;

/**
 * @author Sujit Biswas
 *
 */
public class SOAP12HeaderImpl extends SOAP12HeaderBaseImpl implements SOAP12Header {
    
    /** Creates a new instance of SOAPHeaderImpl */
    public SOAP12HeaderImpl(WSDLModel model, Element e) {
        super(model, e);
    }
    
    public SOAP12HeaderImpl(WSDLModel model){
        this(model, createPrefixedElement(SOAP12QName.HEADER.getQName(), model));
    }
    
    public void accept(SOAP12Component.Visitor visitor) {
        visitor.visit(this);
    }

    public void removeSOAPHeaderFault(SOAP12HeaderFault soapHeaderFault) {
        removeChild(HEADER_FAULT_PROPERTY, soapHeaderFault);
    }

    public void addSOAPHeaderFault(SOAP12HeaderFault soapHeaderFault) {
        appendChild(HEADER_FAULT_PROPERTY, soapHeaderFault);
    }

    public Collection<SOAP12HeaderFault> getSOAPHeaderFaults() {
        return getChildren(SOAP12HeaderFault.class);
    }

    @Override
    public boolean canBeAddedTo(Component target) {
        if (target instanceof BindingInput || target instanceof BindingOutput) {
            return true;
        }
        return false;
    }
}
