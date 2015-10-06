(defproject treasurer-client "0.0.1-SNAPSHOT"
  :description "Small finance management client"
  
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.48"]
                 [rum "0.4.2"]]
  
  :profiles {:dev
             {:plugins [[lein-doo "0.1.4"]
                        ]}}
 
  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-doo "0.1.5"]]
 
  :clean-targets ["dist"]
  
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
