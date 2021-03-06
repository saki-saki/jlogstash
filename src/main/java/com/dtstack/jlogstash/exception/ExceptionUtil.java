/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dtstack.jlogstash.exception;


/**
 * 
 * Reason: TODO ADD REASON(可选)
 * Date: 2016年11月31日 下午1:26:07
 * Company: www.dtstack.com
 * @author sishu.yss
 *
 */
public class ExceptionUtil {
	
    public static String getErrorMessage(Throwable e) {
            StringBuffer sb = new StringBuffer();
            Throwable next = e.getCause();
            if (next != null) {
                    sb.append(next.getMessage() + "\n");
                    StackTraceElement[] nexts = next.getStackTrace();
                    for (StackTraceElement st : nexts) {
                            sb.append(st.getClassName() + "." + st.getMethodName() + "("
                                            + st.getLineNumber() + ")" + "\n");
                    }
            } else {
                    sb.append(e.getMessage() + "\n");
                    StackTraceElement[] sts = e.getStackTrace();
                    if (sts != null) {
                            for (StackTraceElement st : sts) {
                                    sb.append(st.getClassName() + "." + st.getMethodName()
                                                    + "(" + st.getLineNumber() + ")" + "\n");
                            }
                    }
            }
            return sb.toString();
    }

}
