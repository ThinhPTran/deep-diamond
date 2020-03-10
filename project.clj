;;   Copyright (c) Dragan Djuric. All rights reserved.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php) or later
;;   which can be found in the file LICENSE at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.

(defproject uncomplicate/deep-diamond "0.8.0-SNAPSHOT"
  :description "Fast Clojure Deep Learning Library"

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [uncomplicate/commons "0.10.0"]
                 [uncomplicate/neanderthal "0.28.0-SNAPSHOT"]
                 [org.bytedeco/dnnl-platform "1.2.1-1.5.3-SNAPSHOT"]
                 [org.jcuda/jcudnn "10.2.0"]]

  :profiles {:dev {:plugins [[lein-midje "3.2.1"]
                             [lein-codox "0.10.6"]]
                   :global-vars {*warn-on-reflection* true
                                 *assert* false
                                 *unchecked-math* :warn-on-boxed
                                 *print-length* 128}
                   :dependencies [[midje "1.9.9"]
                                  [org.clojure/data.csv "0.1.4"]]}}

  :repositories [["snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots/"
                               :snapshots true :sign-releases false :checksum :warn :update :daily}]]

  :codox {:metadata {:doc/format :markdown}
          :src-dir-uri "http://github.com/uncomplicate/deep-diamond/blob/master/"
          :src-linenum-anchor-prefix "L"
          :output-path "docs/codox"}

  :jvm-opts ^:replace ["-Dclojure.compiler.direct-linking=true"
                       "-Dorg.bytedeco.javacpp.mklml.load=mkl_rt"
                       "-Dorg.bytedeco.javacpp.pathsfirst=true"
                       #_"-XX:MaxDirectMemorySize=16g" "-XX:+UseLargePages"
                       #_"--add-opens=java.base/jdk.internal.ref=ALL-UNNAMED"]

  :javac-options ["-target" "1.8" "-source" "1.8" "-Xlint:-options"]
  :source-paths ["src/clojure" "src/device"])
