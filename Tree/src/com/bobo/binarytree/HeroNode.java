package com.bobo.binarytree;

/**
 * @Description 二叉树数据结构
 * @Date 2021/10/21 21:48
 * @Created by bobo
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //默认空
    private HeroNode right; //默认空

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历方法
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //遍历中序遍历方法
    public void middleOrder() {
        if (this.left != null) {
            this.left.middleOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.middleOrder();
        }
    }

    //遍历后序遍历方法
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * @Description 前序遍历查找
     * @Params no 查找的no
     * @Return 如果找到就返回该node，如果没有找到就返回null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        if (this.no == no) {
            return this;
        }
        //判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    /**
     * @Description 中序遍历查找
     * @Params no 查找的no
     * @Return 如果找到就返回该node，如果没有找到就返回null
     */
    public HeroNode middleOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.middleOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.middleOrderSearch(no);
        }
        return resNode;
    }

    /**
     * @Description 后序遍历查找
     * @Params no 查找的no
     * @Return 如果找到就返回该node，如果没有找到就返回null
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        return null;
    }

    /**
     * @Description 二叉树的删除
     * @Params no 要删除的节点
     * @Return void
     */
    public void deleteNode(int no) {
        //判断当前节点的左子节点是否要删除
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //判断当前节点的右子节点是否是要删除
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //这时向左子树进行递归删除
        if (this.left != null) {
            this.left.deleteNode(no);
        }
        //还是不满足则向右子树进行递归删除
        if (this.right != null) {
            this.right.deleteNode(no);
        }
    }
}
