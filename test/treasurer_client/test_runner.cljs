(ns treasurer-client.test-runner
  (:require [cljs.test :as test]
            [doo.runner :refer-macros [doo-tests]]
            [treasurer-client.core-test]))

(doo-tests 'treasurer-client.core-test)
