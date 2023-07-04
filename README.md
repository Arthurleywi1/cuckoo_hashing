# cuckoo_hashing
Cuckoo hashing is a method for resolving collisions in hash tables by using two hash functions and moving items to different positions in the table if their initial positions are occupied
The results of this repository will provide insights into the advantages and limitations of using cuckoo hashing in practice.


# CUCKOO HASHING ALGORITHM :
```bash
1. Assume that the hash function F (n), which is used for hashing, is
initialised to F(1).
2. Hash key (HK) with Function F (n).
3. Verify whether the area is vacant.
4. Push the current entry into TEMP if the space is not empty.
5. Put HK in the designated spot.
6. Verify the function that inserts TEMP into the location.
7. Return TEMP to HK.
8. Give F a different hash function (n).
9. Continue from step 2 until no collisions occur.
```

Hashing is the best method for storing and
retrieving content after analyzing every scenario, but it still requires
improvement. There are numerous algorithms that address the issue of
collisions, but each algorithm has unique properties and drawbacks. We
can say that Cuckoo Hashing is the best of all the algorithms covered
above. But with less memory and large amounts of data entering the
memory, it can enter an infinite loop and cannot be trusted. However, if
we can find a way to make improvements to this algorithm, it will be the
best algorithm available to deal with the collision problem

# cuckoo hashing demonstration
(https://youtu.be/QaQ9PAvZN6I)

