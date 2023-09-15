/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package software.iridium.entity;

import jakarta.persistence.*;
import java.io.Serial;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AttributeOverride(
    name = "id",
    column = @Column(name = "in_progress_external_identity_provider_authorization_id"))
@Table(name = "in_progress_external_identity_provider_authorizations")
public class InProgressExternalIdentityProviderAuthorizationEntity extends AbstractEntity {

  @Serial private static final long serialVersionUID = -6454913453656270364L;

  @Column(name = "state", length = 255, nullable = false)
  private String state;

  @Column(name = "redirect_uri", length = 255, nullable = false)
  private String redirectUri;

  @Column(name = "client_id", length = 42, nullable = false)
  private String clientId;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "expiration", nullable = false)
  private Date expiration;

  @ManyToOne
  @JoinColumn(name = "external_identity_provider_id")
  private ExternalIdentityProviderEntity provider;

  /**
   * public String getState() { return state; }
   *
   * <p>public void setState(final String state) { this.state = state; }
   *
   * <p>public String getRedirectUri() { return redirectUri; }
   *
   * <p>public void setRedirectUri(final String redirectUri) { this.redirectUri = redirectUri; }
   *
   * <p>public String getClientId() { return clientId; }
   *
   * <p>public void setClientId(final String clientId) { this.clientId = clientId; }
   *
   * <p>public Date getExpiration() { return expiration; }
   *
   * <p>public void setExpiration(final Date expiration) { this.expiration = expiration; }
   *
   * <p>public ExternalIdentityProviderEntity getProvider() { return provider; }
   *
   * <p>public void setProvider(final ExternalIdentityProviderEntity provider) { this.provider =
   * provider; }
   */
}
