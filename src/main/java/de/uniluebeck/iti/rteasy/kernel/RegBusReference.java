/*
 * Copyright (c) 2003-2013, University of Luebeck, Institute of Computer Engineering
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the University of Luebeck, the Institute of Computer
 *       Engineering nor the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific prior
 *       written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE UNIVERSITY OF LUEBECK OR THE INSTITUTE OF COMPUTER
 * ENGINEERING BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */


package de.uniluebeck.iti.rteasy.kernel;
import de.uniluebeck.iti.rteasy.CircuitPortReference;

public class RegBusReference extends CircuitPortReference {
    public RegBus regBus;

  RegBusReference(RegBus rb, BitRange br) {
    super(rb.getVHDLName(),(rb instanceof Bus?"":"out"),rb.getRegBusId(),br);
    regBus = rb;
  }

  RegBusReference(RegBus rb, int begin, int end) {
    super(rb.getVHDLName(),(rb instanceof Bus?"":"out"),rb.getRegBusId(),new BitRange(begin,end,rb.getDirection()));
    regBus = rb;
  }

  RegBusReference(Object[] entry) {
    super(((RegBus) entry[0]).getVHDLName(),(entry[0] instanceof Bus?"":"out"),((RegBus) entry[0]).getRegBusId(),
      new BitRange(((Integer) entry[1]).intValue(),
		   ((Integer) entry[2]).intValue(),((RegBus) entry[0]).getDirection()));
    regBus = (RegBus) entry[0];
  }

  public String toVHDL() {
    return regBus.getVHDLName()+bitRange.toVHDL();
  }

  public String getVHDLPortMap(String port) {
    if(regBus instanceof Bus) return super.getVHDLPortMap();
    else return super.getVHDLPortMap(port);
  }
}


