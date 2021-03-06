/*******************************************************************************
 * Copyright 2015
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package de.tudarmstadt.ukp.wikipedia.util;

import java.util.*;

import org.hibernate.Session;

import de.tudarmstadt.ukp.wikipedia.api.DatabaseConfiguration;
import de.tudarmstadt.ukp.wikipedia.api.WikiConstants;
import de.tudarmstadt.ukp.wikipedia.api.hibernate.WikiHibernateUtil;

public class HibernateUtilities implements WikiConstants {

    private DatabaseConfiguration dbConfig;
    
    public HibernateUtilities(Language pLanguage, DatabaseConfiguration dbConfig) {
        this.dbConfig = dbConfig;
    }
    
    /** Hibernate IDs are needed to load an object from the database.
     *  Internal references are via pageIDs.
     * @return A mapping of pageIDs to hibernate IDs. 
     */
    public Map<Integer, Long> getIdMappingPages() {
        Map<Integer, Long> idMapping = new HashMap<Integer, Long>();
        
        Session session = WikiHibernateUtil.getSessionFactory(this.dbConfig).getCurrentSession();
        session.beginTransaction();
        Iterator results = session.createQuery("select page.id, page.pageId from Page as page").list().iterator();
        while (results.hasNext()) {
            Object[] row = (Object[]) results.next();
            // put (pageID, id)
            idMapping.put((Integer) row[1], (Long) row[0]);
        }
        session.getTransaction().commit();
        return idMapping;
    }

    /** Hibernate IDs are needed to load an object from the database.
     *  Internal references are via pageIDs.
     * @return A mapping of pageIDs to hibernate IDs. 
     */
    public Map<Integer, Long> getIdMappingCategories() {
        Map<Integer, Long> idMapping = new HashMap<Integer, Long>();
        
        Session session = WikiHibernateUtil.getSessionFactory(this.dbConfig).getCurrentSession();
        session.beginTransaction();
        Iterator results = session.createQuery("select cat.id, cat.pageId from Category as cat").list().iterator();
        while (results.hasNext()) {
            Object[] row = (Object[]) results.next();
            // put (pageID, id)
            idMapping.put((Integer) row[1], (Long) row[0]);
        }
        session.getTransaction().commit();
        return idMapping;
    }
}
