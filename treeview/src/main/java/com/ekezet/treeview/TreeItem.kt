/*
 * Copyright 2019 Károly Kiripolszky
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ekezet.treeview

interface TreeItem<out T> {
    val data: T
    var depth: Int
    var isExpanded: Boolean
    val viewType: Int

    companion object {
        inline infix fun <reified T> from(data: T): TreeItem<T> =
            object : TreeItem<T> {
                override val data = data
                override var depth: Int = 0
                override var isExpanded = false
                override val viewType = T::class.hashCode()
            }
    }
}
