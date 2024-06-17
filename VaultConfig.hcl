storage "file" {
  path    = "/Users/11490075/Documents/vaultDB"
}


listener "tcp" {
  address     = "0.0.0.0:8200"
  tls_disable = true
}
# on product use TLS cer

api_addr = "http://127.0.0.1:8200"
cluster_addr = "https://127.0.0.1:8201"
ui=true
# user Interface On api_addr url