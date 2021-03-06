/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jsqrl.service;

import org.jsqrl.model.SqrlUser;

/**
 * A required service for retrieving users that can authenticate
 * with SQRL. Have your service which manages user data implement
 * this interface and implement the required functionality.
 * <p>
 * Created by Brent Nichols
 */
public interface SqrlUserService<T extends SqrlUser> {
    /**
     * Querys for the user by their public key
     *
     * @param identityKey The user's public key
     * @return Returns an object representing the user
     */
    T getUserBySqrlKey(String identityKey);

    /**
     * If the client was identified by a previous identity,
     * update that old identity with the new on they are carrying
     *
     * @param previousIdentityKey The old identity key to be replaced
     * @param identityKey The user's updated identity key
     * @return Returns true if the update was successful
     */
    Boolean updateIdentityKey(String previousIdentityKey, String identityKey);

    /**
     * Registers the user
     *
     * @param identityKey     The user's public key
     * @param serverUnlockKey The user's server unlock key
     * @param verifyUnlockKey The user's verify unlock key
     * @return Returns an object to represent the user
     */
    T registerSqrlUser(String identityKey, String serverUnlockKey, String verifyUnlockKey);

    /**
     * The function that will disable the user
     *
     * @param identityKey The user's public key
     * @return Returns true if the disable was successful, otherwise false
     */
    Boolean disableSqrlUser(String identityKey);

    /**
     * The function that will re-enable the user
     *
     * @param identityKey The user's public key
     * @return Returns true if the enable was successful, otherwise false
     */
    Boolean enableSqrlUser(String identityKey);

    /**
     * The function that will remove the user
     *
     * @param identityKey The user's public key
     * @return Returns true if the disable was successful, otherwise false
     */
    Boolean removeSqrlUser(String identityKey);
}
