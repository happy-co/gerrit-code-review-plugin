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

import java.util.logging.Logger;
import javax.annotation.Nonnull;
import jenkins.scm.api.SCMHead;
import jenkins.scm.api.mixin.ChangeRequestCheckoutStrategy;
import jenkins.scm.api.mixin.ChangeRequestSCMHead2;

/** Head corresponding to a change. */
public class ChangeSCMHead extends SCMHead implements ChangeRequestSCMHead2 {

  private static final Logger LOGGER = Logger.getLogger(ChangeSCMHead.class.getName());

  private static final long serialVersionUID = 1;

  private final String branchName;

  ChangeSCMHead(String branchName, String changeNumber) {
    super(changeNumber);
    this.branchName = branchName;
  }

  /** {@inheritDoc} */
  @Override
  public String getPronoun() {
    return Messages.ChangeSCMHead_Pronoun();
  }

  /** {@inheritDoc} */
  @Nonnull
  @Override
  public ChangeRequestCheckoutStrategy getCheckoutStrategy() {
    return ChangeRequestCheckoutStrategy.HEAD;
  }

  @Nonnull
  @Override
  public String getOriginName() {
    return branchName;
  }

  /** {@inheritDoc} */
  @Nonnull
  @Override
  public String getId() {
    return "change-" + getName();
  }

  @Nonnull
  @Override
  public SCMHead getTarget() {
    return new SCMHead(branchName);
  }
}
