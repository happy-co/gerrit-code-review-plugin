// Copyright (C) 2018 GerritForge Ltd
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package jenkins.plugins.gerrit;

public class GerritProjectEvent {
  public final GerritProjectName project;
  public final String type;

  public GerritProjectEvent(GerritProjectName project, String type) {
    this.project = project;
    this.type = type;
  }

  @Override
  public String toString() {
    return "Gerrit event " + type + project != null ? (" on project " + project) : "";
  }

  public boolean matches(String remoteUrl) {
    return project != null && remoteUrl.endsWith(project.name);
  }
}
