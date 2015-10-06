(defproject treasurer-client "0.0.1-SNAPSHOT"
  :description "Small finance management client"
  
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.48"]
                 [rum "0.4.2" :exlcusions [cljsjs/react]]
                 [prismatic/dommy "1.1.0"]
                 [com.lucasbradstreet/cljs-uuid-utils "1.0.2"]
                 [cljs-react-test "0.1.3-SNAPSHOT"]
                 [cljsjs/react-with-addons "0.13.3-0"]]
  :profiles {:dev
             {:dependencies [[cljs-react-test "0.1.3-SNAPSHOT"]]
              :plugins [[lein-doo "0.1.4"]]}}
 
  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-doo "0.1.5"]]
 
  :clean-targets ["dist/bundle.js" "dist/treasurer.js" "dist/out" "dist/test"]
  
  :cljsbuild {:builds
              {:dev
               {:source-paths ["src"]
                :compiler {:main treasurer_client.core
                           :output-to "dist/treasurer.js"
                           :output-dir "dist/out"
                           :target :nodejs
                           :cache-analysis true
                           :optimizations :none
                           :source-map true}}
               :test
               {:source-paths ["src" "test"]
                :compiler {:output-to "dist/test/compiled.js"
                           :main treasurer-client.test-runner
                           :optimizations :none}}
               :prod
               {:source-paths ["src/treasurer_server"]
                :compiler {:main treasurer_client.core
                           :output-to "dist/bundle.js"
                           :target :nodejs
                           :cache-analysis true
                           :optimizations :advanced}}}}
  )
