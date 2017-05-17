from brootforce import is_prime
from erythrophene_sieve import primes
from witness_f import is_prime_witness

n = int(input('enter n: '))
print(is_prime(n))
print(primes(n))
print(is_prime_witness(n))