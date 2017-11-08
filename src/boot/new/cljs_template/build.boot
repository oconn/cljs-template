(set-env!
 :jvm-opts ^:replace ["-Xmx1g" "-server"]
 :source-paths #{"src/cljs" "src/clj" "scss"}
 :resource-paths #{"resources"}
 :dependencies '[[bidi                        "2.1.2"]
                 [com.cemerick/url            "0.1.1"]
                 [kibu/pushy                  "0.3.8"]
                 [oconn/re-frame-notifier     "0.1.0-SNAPSHOT"]
                 [oconn/re-frame-request      "0.1.0-SNAPSHOT"]
                 [org.clojure/clojure         "1.9.0-RC1"]
                 [org.clojure/clojurescript   "1.9.946"]
                 [reagent                     "0.8.0-alpha2"]
                 [re-frame                    "0.10.2"]

                 [adzerk/boot-cljs                "2.1.4"   :scope "test"]
                 [adzerk/boot-cljs-repl           "0.3.3"   :scope "test"]
                 [adzerk/boot-reload              "0.5.2"   :scope "test"]
                 [com.cemerick/piggieback         "0.2.2"   :scope "test"]
                 [deraen/boot-sass                "0.3.1"   :scope "test"]
                 [danielsz/boot-autoprefixer      "0.1.0"   :scope "test"]
                 [org.bouncycastle/bcprov-jdk15on "1.58"    :scope "test"]
                 [org.clojure/tools.nrepl         "0.2.13"  :scope "test"]
                 [org.slf4j/slf4j-nop             "1.7.21"  :scope "test"]
                 [pandeiro/boot-http              "0.8.3"   :scope "test"]
                 [powerlaces/boot-cljs-devtools   "0.2.0"   :scope "test"]
                 [re-frisk                        "0.5.0"   :scope "test"]
                 [ring/ring-core                  "1.6.2"   :scope "test"]
                 [tolitius/boot-check             "0.1.5"   :scope "test"]
                 [weasel                          "0.7.0"   :scope "test"]])

(require
 '[adzerk.boot-cljs              :refer [cljs]]
 '[adzerk.boot-cljs-repl         :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload            :refer [reload]]
 '[deraen.boot-sass              :refer [sass]]
 '[danielsz.autoprefixer         :refer [autoprefixer]]
 '[pandeiro.boot-http            :refer [serve]]
 '[tolitius.boot-check           :as    check]
 '[powerlaces.boot-cljs-devtools :refer [cljs-devtools dirac]])

(deftask build
  []
  (comp (speak)
        (cljs)
        (sass)
        (autoprefixer :files ["main.css"]
                      :browsers "last 2 versions")))

(deftask run
  []
  (comp (serve :not-found 'server/not-found-handler)
        (watch)
        (cljs-repl)
        (reload)
        (build)))

(deftask production
  "Sets production options."
  []
  (task-options! cljs {:optimizations :advanced})
  identity)

(deftask development
  "Sets development options."
  []
  (task-options! cljs {:optimizations :none
                       :compiler-options
                       {:warnings true
                        :pretty-print true}}
                 reload {:on-jsload '{{name}}.core/mount-root})
  identity)

(deftask dev
  "Kicks off development process. This includes live reload and file watching."
  []
  (comp (development)
        (run)))

(deftask lint
  "Check and analyze source code."
  []
  (comp (sift :include #{#"\.clj[cs]?$"})
        (check/with-kibit)
        (check/with-bikeshed)))
