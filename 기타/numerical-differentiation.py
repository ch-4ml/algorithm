import numpy as np

def func1(input_obj):
    [[w, x], [y, z]] = input_obj
    return w * x + x * y * z + 3 * w + z * y ** 2

def numericalDifferentiation(f, x):
    deltaX = 1e-4
    coefficient = np.zeros_like(x)
    it = np.nditer(x, flags=['multi_index'], op_flags=['readwrite'])

    while not it.finished:
        idx = it.multi_index
        tmp_val = x[idx]

        x[idx] = tmp_val + deltaX
        fx1 = f(x) # f(x + deltaX)

        x[idx] = tmp_val - deltaX
        fx2 = f(x) # f(x - deltaX)

        coefficient[idx] = (fx1 - fx2) / (2 * deltaX)

        x[idx] = tmp_val
        it.iternext()
    return coefficient

result = numericalDifferentiation(func1, np.array([[1., 2.], [3., 4.]]))
print(result)
