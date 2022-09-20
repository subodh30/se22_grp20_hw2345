## Column Data
    It is an abstract class inherited by Numbers sand Symbols class
## Columns
    def Columns()
        It maintains the summaries of columns

    def getY()
        This function returns a list of all the dependant values 

    def getX()
        This function returns a list of independant values


## CSV
    def csv()
        This function takes in a filepath as input and uses a BufferedReader to read the csv file line by line.
## Data
    Data Class keeps a list of rows and their sumaries in columns
    
    def add()
        This function fetches a row and adds its cell values to the columns.
    
    def round()
        This function takes in a value and the number of decimal places as input and returns the rounded number upto the given decimal places.

    def stats()
        This function is responsible for performing all statistical operations on the given data.
        It takes in the required parameters and the function name which needs to be operated on the given data.
        The output of this operation is returned to the calling function.
## Numbers
    Numbers class keeps a summary of numbers

    def mid()
        It returns the median of the values present in the data

    def div()
        It returns the standard deviation for all the values
        The value returned is (90th percentile - 10th percentile)/2.56
## Row

    It holds one record, i.e. cell values of a row
    
    def clone_list()
        This function initializes 3 variables in the class constructor.
        Cells is a copy of the input parameter
        Cooked is a deep copy of the input parameter i.e. a List<String>
## Symbols

    Symbols keep a summary of symbols of a given column

    def add()
        This function adds a valid symbol to the Symbol Map. 

    def mid()
        This function returns the symbol from the symbol map having the highest frequency.

    Double div(int decimalPlaces)
        It returns entropy value by calculating the probability

## The
    The is a configuration class, which has a set of fields which can be set by the command line arguments. 
    It follows Singleton Design pattern as the configurations are set only while running the program and it should be accessible to other classes.