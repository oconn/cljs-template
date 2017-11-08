(set-env!
 :resource-paths #{"src"}
 :dependencies
 '[[org.clojure/clojure "RELEASE"]
   [boot/new "RELEASE"]
   [adzerk/boot-test "RELEASE" :scope "test"]])

(def project 'oconn/cljs-template)
(def version "0.1.0-SNAPSHOT")

(task-options!
 pom {:project     project
      :version     version
      :description "Create new CLJS projects with ease"
      :url         "http://oconn/template"
      :scm         {:url "https://github.com/oconn/cljs-template"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(require '[adzerk.boot-test :refer [test]]
         '[boot.new :refer [new]])
