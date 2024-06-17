# POC : SPRING BOOT + VAULT

POC uses postgres. Please switch to orcl.
# -------------------SERVER-------------------

# SETUP VAULT SERVER !!

# 1 Create VaultConfig.hcl 

# 2 start vault service
    //$vault server -config=VaultConfig.hcl 

# 3 Unseal Vault {READ!!}
    //To access the vault on the server, it is necessary to unseal it
    because the vault is always sealed by default.
    To unseal the vault, you need 3 out of 5 keys. 
    Only then can you access the vault.

# 4 Use : $vault operator init
    // The command $vault operator init can be used only once.BE CAREFUL!!!!
    This command initializes the vault and generates a total of 5 keys and a Root token.

# 5 Unseal : $vault operator unseal <unseal-key> 3 Key
    //vault operator unseal <unseal-key-1>
    vault operator unseal <unseal-key-2>
    vault operator unseal <unseal-key-3>


# 6 login 
    //$vault login <your-root-token>
    
# 7 Create Policies
    // Create VaultPolicies.hcl

# 8 Set Policies 
    //$vault policy write <name/Role_policies> <path.hcl>
        EX
    $vault policy write mypolicies /.../policiesFile.hcl
    you can check list policies...
    $vault policy list

# 9 Create Sub Token Role 
    // $vault token create -policy="<name/Role_policies>"

# 10 Check Policy Token 
    //$vault token lookup <Token>

# 11 Set env Token / login
    //vault login <Token>
    OR
    export VAULT_TOKEN='<TOKEN>'


# -------------------USER-------------------

# Login
    //$vault login <your-token>
# Operation
    --Insert / Update
            $vault kv put <PATH> <KEY>=<VALUE>
        --EX
            $vault kv put secret/<Application.name> <Key>=<Value>      #Root

        --OR use Profile
            $spring.profiles.active=dev,local,remote

            $vault kv put secret/<Application.name>/dev <Key>=<Value>      # Use profile dev

            $vault kv put secret/<Application.name>/local <Key>=<Value>      # Use profile dev < local

            $vault kv put secret/<Application.name>/remote <Key>=<Value>      # Use profile dev < local < remote
    --Delete
            $vault kv delete <PATH>
    --Read/Selete
            $vault kv get <PATH>
    

    --Token
        --use now
            $vault token lookup
        --OR
            $vault token lookup <Token>

    --Policy
        --Read
            $vault policy read <Policy_name>


https://developer.hashicorp.com/vault
https://www.javatodev.com/hashicorp-vault-spring-boot/



