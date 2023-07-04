# class HashTable:
#     def __init__(self, size):
#         self.size = size
#         self.table = [None] * size

#     def insert(self, key, value):
#         index = hash(key) % self.size
#         if self.table[index] is None:
#             self.table[index] = (key, value)
#         else:
#             # Collision! Try the next index
#             print("Collision:", key, value, "at index", index)
#             next_index = (index + 1) % self.size
#             while self.table[next_index] is not None:
#                 print("Collision:", key, value, "at index", next_index)
#                 next_index = (next_index + 1) % self.size
#             self.table[next_index] = (key, value)

#     def lookup(self, key):
#         index = hash(key) % self.size
#         if self.table[index] is None:
#             return None
#         elif self.table[index][0] == key:
#             return self.table[index][1]
#         else:
#             # Check for collision
#             next_index = (index + 1) % self.size
#             while self.table[next_index] is not None and self.table[next_index][0] != key:
#                 next_index = (next_index + 1) % self.size
#             if self.table[next_index] is None:
#                 return None
#             else:
#                 return self.table[next_index][1]
 
def print_collisions(hash_table): 
    for i, basket in enumerate(hash_table): # Loop over each basket in the hash table
        if len(basket) > 1: # If there's more than one item in the basket
            print(f"Collision index {i}: {basket}") # Print the basket

hash_table = [[] for _ in range(10)] # Create a list of 10 empty lists
 
# Add some values to the hash table
hash_table[3].append("grape") # Add "grape" to the basket at index 3
hash_table[4].append("apple") # Add "apple" to the basket at index 5
hash_table[4].append("banana") # Add "banana" to the basket at index 5
hash_table[5].append("orange") # Add "orange" to the basket at index 7
hash_table[5].append("kiwi") # Add "kiwi" to the basket at index 7

print_collisions(hash_table)


