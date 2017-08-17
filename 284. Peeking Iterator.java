// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer firstElem;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
        firstElem = internalNext();
	}
    
    private Integer internalNext() {
        if(iter.hasNext()) {
            return iter.next();
        } else {
            return null;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return firstElem;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = firstElem;
        firstElem = internalNext();
        return res;
	}

	@Override
	public boolean hasNext() {
	    return firstElem != null;
	}
}

/*
这种题目一个固定的套路就是在call next的时候，
先存储下来当前的值，然后再进行处理，
返回之前存储下来的值即可。

注意利用一个自定义的internalNext函数来辅助处理，不涉及该问题中要求解决的各种函数。
*/