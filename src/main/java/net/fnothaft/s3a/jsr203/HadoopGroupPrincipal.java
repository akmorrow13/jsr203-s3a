/*
 * Copyright 2016 Damien Carol <damien.carol@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package net.fnothaft.s3a.jsr203;

import java.nio.file.attribute.GroupPrincipal;

import org.apache.hadoop.security.UserGroupInformation;

/**
 * Implement {@link GroupPrincipal}.
 */
public class HadoopGroupPrincipal implements GroupPrincipal {

  private UserGroupInformation ugi;

  public HadoopGroupPrincipal(HadoopFileSystem hdfs, String name) {
    this.ugi = UserGroupInformation.createRemoteUser(name);
  }

  @Override
  public String getName() {
    return this.ugi.getUserName();
  }

}
