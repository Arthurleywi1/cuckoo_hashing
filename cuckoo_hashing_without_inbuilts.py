class CuckooHashTable:
    def __init__(self, size): 
        self.size = size 
        self.table1 = [None] * size # Creating a list of size elements, all set to None
        self.table2 = [None] * size
    def custom_hash(self, key):
        # A simple example of a custom hash function:
        # add up the ASCII values of the characters in the key
        # and take the remainder when divided by the size of the table
        return sum(ord(c) for c in key) % self.size # ord() returns the ASCII value of a character

    def insert(self, key):
        # find the location to insert the key
        location = self.custom_hash(key) # Use the custom hash function to find the location
        if self.table1[location] is None: # If the location is empty
            self.table1[location] = key # Insert the key
        else:
            # relocate the key in the second table 
            location = self.custom_hash(key)
            if self.table2[location] is None:
                self.table2[location] = key
            else:
                # if both locations are occupied, kick out the key in table2 and insert the new key
                temp = self.table2[location]
                self.table2[location] = key
                self.insert(temp)

    def search(self, key):
        # search for the key in both tables
        location = self.custom_hash(key) 
        if self.table1[location] == key: # If the key is found
            return location # Return the location
        location = self.custom_hash(key) # Otherwise, search the second table
        if self.table2[location] == key: # If the key is found
            return location # Return the location
        return None

# Create a hash table with 10 slots
hash_table = CuckooHashTable(10)

# Add some values to the hash table
hash_table.insert("grape")
hash_table.insert("apple")
hash_table.insert("banana")
hash_table.insert("orange")
hash_table.insert("kiwi")

# Print the hash table
print(hash_table.table1)
print(hash_table.table2)

# Search for some values in the hash table
print(hash_table.search("grape"))
print(hash_table.search("apple"))
print(hash_table.search("banana"))
print(hash_table.search("orange"))
print(hash_table.search("kiwi"))

# Print the hash table
print(hash_table.table1)
print(hash_table.table2)

# class CuckooHashTable:
#     def __init__(self, size):
#         self.size = size
#         self.table = [[] for _ in range(size)]


#     def hash1(self, key):
#         #first hash function, for example:
#         return key % self.size

#     def hash2(self, key):
#         #second hash function, for example:
#         return hash(key) % self.size

#     def insert(self, key):
#         # find the location to insert the key
#         location = self.hash1(key)
#         if self.table1[location] is None:
#             self.table1[location] = key
#         else:
#             # relocate the key in the second table
#             location = self.hash2(key)
#             if self.table2[location] is None:
#                 self.table2[location] = key
#             else:
#                 # if both locations are occupied, kick out the key in table2
#                 temp = self.table2[location]
#                 self.table2[location] = key
#                 self.insert(temp)

#     def search(self, key):
#         # search for the key in both tables
#         location = self.hash1(key)
#         if self.table1[location] == key:
#             return location
#         location = self.hash2(key)
#         if self.table2[location] == key:
#             return location
#         return None

