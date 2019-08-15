#!/usr/bin/env fish

function access_consul
  argparse -n access_consul 'h/help' -- $argv
  or return 1

  if set -lq _flag_help
    echo "curl-access-config.fish: Access Value from Consul"
    return
  end
  echo "curl -X GET http://localhost:8080/prop"
  curl -X GET "http://localhost:8080/prop"
  echo ""
  echo "curl -X GET http://localhost:8080/value"
  curl -X GET "http://localhost:8080/value"
end

access_consul $argv
