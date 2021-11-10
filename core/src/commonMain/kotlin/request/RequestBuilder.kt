/*
 *    Copyright 2021 NyCode
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package dev.nycode.github.request

import dev.nycode.github.utils.GitHubWrapperInternals
import io.ktor.client.request.HttpRequestBuilder

@GitHubWrapperInternals
public class RequestBuilder(
    @PublishedApi internal val requests: MutableList<HttpRequestBuilder.() -> Unit> = mutableListOf()
) {
    public fun request(builder: HttpRequestBuilder.() -> Unit) {
        requests += builder
    }

    public operator fun component1(): MutableList<HttpRequestBuilder.() -> Unit> = requests
}
