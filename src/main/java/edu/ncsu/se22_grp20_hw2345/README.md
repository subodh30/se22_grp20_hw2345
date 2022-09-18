## Column Data
    It is the blueprint for a Column Data
## Columns
    def Columns()
        It cycles through the column names and adds the entries into allData

    def getY()
        This function returns a list of all the values containing '+' and '-' 

    def getX()
        This function returns a list of values not containing '+' and '-'


## CSV
    def csv()
        This function takes in a filepath as input and uses a BufferedReader to read the csv file line by line.
## Data
    def add()
        This function fetches every next row and adds it to the column.
    
    def round()
        This function takes in a value and the number of decimal places as input and returns the rounded number upto the given decimal places.

    def stats()
        This function is responsible for performing all statistical operations on the given data.
        It takes in the required parameters and the function name which needs to be operated on the given data.
        The output of this operation is returned to the calling function.
## Numbers
    def mid()
        It returns the median of the values present in the data

    def div()
        It returns the standard deviation for all the values
        The value returned is (90th percentile - 10th percentile)/2.56
## Row
    def clone_list()
        This function initializes 3 variables in the class constructor.
        Cells is a copy of the input parameter
        Cooked is a deep copy of the input parameter i.e. a List<String>
## Symbols
    def add()
        This function takes in the symbol as a parameter and checks whether its not null and is not a '?'.
        If the conditions are met, the count is incremented and added to a map. 

    def mid()
        This function returns the symbol from the symbol map having the highest frequency.
        It returns entropy value by calculating probability. 

    

## The