/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.lucasward.grails.plugin.inheritance

import net.lucasward.grails.plugin.inheritance.entry.ProfessionalPerformanceYear
import org.hibernate.envers.Audited

@Audited
class ProfessionalPlayer extends AbstractPlayer{

    SortedSet<ProfessionalPerformanceYear> years = new TreeSet<ProfessionalPerformanceYear>()

    static hasMany = [years: ProfessionalPerformanceYear]

    static mapping = {
        sort: 'name'
        years: cache: true
        tablePerHierarchy true
        years cascade: "all,delete-orphan"
    }
}
