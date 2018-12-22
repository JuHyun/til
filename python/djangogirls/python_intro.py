print("Hello, Django girls");

def hi(name):
    print("hi, %s" % name)
    print('how are you')

hi("estel")

girls = ['Rachel', 'Monica', 'Phoebe', 'Ola', 'You']

for name in girls:
    hi(name)
    print('Next girl')
