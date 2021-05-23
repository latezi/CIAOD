class ClassForRehash:
    def __init__(self, value1):
        self.value1 = value1
        self.hash = value1 % ClassForRehash.MAX_HASH_TABLE
        self.hash2 = int((value1 * 21 + 2) % ClassForRehash.MAX_HASH_TABLE)
    MAX_HASH_TABLE = 10
   
class SimpleRehashTable:

    def __init__(self, length):
        self.table = [None] * length

    def add_el(self, element): #Если ячейка пустая-добавляем элемент.
        original_hash = element.hash
        if self.table[original_hash] is None:
            self.table[original_hash] = element
            print("объект со значением %i имеет хэш: %i "
                  % (self.table[original_hash].value1, element.hash))
            return
      
        new_hash = original_hash + 1
        while new_hash != original_hash:
            if new_hash >= len(self.table):
                new_hash = 0
                continue
            if self.table[new_hash] is None:
                element.hash = new_hash
                self.table[new_hash] = element
                print("объект со значением %i имеет хэш: %i (рехешировано. коллизия была в хеше: %i)"
                      % (self.table[new_hash].value1, element.hash, original_hash))
                return
            new_hash += 1
        print("таблица заполнена!")
        return
        
class RandomRehashTable:
    
    def __init__(self, length):
        self.table = [None] * length

    def add_el(self, element):
        original_hash = element.hash2
        if self.table[original_hash] is None:
            self.table[original_hash] = element
            print("объект со значением %i имеет хэш: %i (рехеширование не требовалось)"
                  % (self.table[original_hash].value1, original_hash))
            return

      
  # случайное рехеширование
      
        table_len = len(self.table)
        new_hash = random.randint(0,9)
        if self.table[new_hash] is None:
                element.hash2 = new_hash
                self.table[new_hash] = element
                print("объект со значением %i имеет хэш: %i (рехешировано. коллизия была в хеше: %i)"
                      % (self.table[new_hash].value1, element.hash2, original_hash))
                return
        while self.table[new_hash] is not None: 
            new_hash = random.randint(0,9)    
            if self.table[new_hash] is None:
                element.hash2 = new_hash
                self.table[new_hash] = element
                print("объект со значением %i имеет хэш: %i (рехешировано. коллизия была в хеше: %i)"
                      % (self.table[new_hash].value1, element.hash2, original_hash))
                return
        print("Не удалось найти свободный хеш в таблице!")
        return
        
class ChainRehashTable:

    def __init__(self, length):
        self.table = [None] * length

    def add_el(self, element):
        
       # метод цепочек
        
        original_hash = element.hash
        if self.table[original_hash] is None:
            self.table[original_hash] = [element]
            return
        else:
            length = len(self.table[original_hash])
            self.table[original_hash].append(element)
            return