(ns boot.new.cljs-template
  (:require [boot.new.templates :as boot-new]
            [clojure.string :as str]))

(defn cljs-template
  "Generates a new CLJS project."
  [name]
  (let [render (boot-new/renderer "cljs-template")
        main-ns (boot-new/multi-segment (boot-new/sanitize-ns name))
        data {:raw-name    name
              :name        (boot-new/project-name name)
              :namespace   main-ns
              :nested-dirs (boot-new/name-to-path main-ns)
              :sanitized   (boot-new/name-to-path name)
              :year        (boot-new/year)
              :date        (boot-new/date)}]

    (println (str "Generating fresh project '" name "' using the cljs-template."))

    (boot-new/->files
     data

     ;; Project Files
     ["README.md"       (render "README.md" data)]
     ["build.boot"      (render "build.boot" data)]
     ["boot.properties" (render "boot.properties" data)]
     [".gitignore"      (render "gitignore" data)]
     [".java-version"   (render "java-version" data)]

     ;; Top level files
     ["src/cljs/{{sanitized}}/core.cljs"   (render "src/cljs/core.cljs" data)]
     ["src/cljs/{{sanitized}}/router.cljs" (render "src/cljs/router.cljs" data)]

     ;; Containers
     ["src/cljs/{{sanitized}}/containers/main.cljs"      (render "src/cljs/containers/main.cljs" data)]
     ["src/cljs/{{sanitized}}/containers/home.cljs"      (render "src/cljs/containers/home.cljs" data)]
     ["src/cljs/{{sanitized}}/containers/not_found.cljs" (render "src/cljs/containers/not_found.cljs" data)]

     ;; Datebase objects
     ["src/cljs/{{sanitized}}/db/core.cljs"   (render "src/cljs/db/core.cljs" data)]

     ;; Events
     ["src/cljs/{{sanitized}}/events/core.cljs"        (render "src/cljs/events/core.cljs" data)]
     ["src/cljs/{{sanitized}}/events/bootstrap.cljs"   (render "src/cljs/events/bootstrap.cljs" data)]
     ["src/cljs/{{sanitized}}/events/development.cljs" (render "src/cljs/events/development.cljs" data)]

     ;; Subscriptions
     ["src/cljs/{{sanitized}}/subs/core.cljs"      (render "src/cljs/subs/core.cljs" data)]
     ["src/cljs/{{sanitized}}/subs/bootstrap.cljs" (render "src/cljs/subs/bootstrap.cljs" data)]

     ;; Interceptors
     ["src/cljs/{{sanitized}}/interceptors/core.cljs" (render "src/cljs/interceptors/core.cljs" data)]
     ["src/cljs/{{sanitized}}/interceptors/spec.cljs" (render "src/cljs/interceptors/spec.cljs" data)]

     ;; Styles
     ["scss/css/main.scss"              (render "scss/css/main.scss" data)]
     ["scss/css/constants/_colors.scss" (render "scss/css/constants/_colors.scss" data)]

     ;; Dev Server
     ["src/clj/server.clj" (render "src/clj/server.clj" data)]

     ;; Resources
     ["resources/index.html"      (render "resources/index.html" data)]
     ["resources/dev_index.html"  (render "resources/dev_index.html" data)]
     ["resources/js/app.cljs.edn" (render "resources/js/app.cljs.edn" data)])))
