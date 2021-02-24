# RSA-implementation

1. Key Generation

    Get two different large prime numbers p and q
        Using Miller-Rabin Test

    Let n = p * q

    Let φ(n) = (p-1) * (q-1)

    Choose a small, odd integer number e, where 1 < e < φ(n) and e is a co-prime to φ(n).
        Using Euclidean Algorithm

    Calculate the integer number d, where e*d ≡ 1 mod φ(n) and 1 < d < φ(n).
        Using Extended Euclidean Algorithm

    The public key of the RSA is the pair PK = (n, e)

    The secret key of the RSA is the pair SK = (n, e)

2. Encryption

    To encrypt the message m (where m < n) using the public key PK = (n, e) following formula is used: (Fast Modular Exponent)
    c := EncPK(m) = m^e (mod n).

3. Decryption

    To decrypt the secret message c using the secret key d following formula is used: (Fast Modular Exponent)
    m := DecSK(c) = c^d (mod n).

