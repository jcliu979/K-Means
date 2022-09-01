# K-Means
A pyramid k means clustering algorithm for the NIST test suite

The NIST test suite is a collection of 15 different tests for pseudo random number generators. This algorithm creates vectors from the test results of PRNG output and clusters them and outputs how often tests share clusters with each other. The tests that appear most often in clusters are the tests that are most similar. This allows us to see which tests are unique to others.
