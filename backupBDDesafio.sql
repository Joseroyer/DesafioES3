PGDMP     ;    ,        	    	    {            desafio    12.13    12.13                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16586    desafio    DATABASE     �   CREATE DATABASE desafio WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE desafio;
                postgres    false            �            1259    16597    cidade    TABLE     p   CREATE TABLE public.cidade (
    id integer NOT NULL,
    nome character varying(100),
    estado_id integer
);
    DROP TABLE public.cidade;
       public         heap    postgres    false            �            1259    16595    cidade_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cidade_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.cidade_id_seq;
       public          postgres    false    205                       0    0    cidade_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.cidade_id_seq OWNED BY public.cidade.id;
          public          postgres    false    204            �            1259    16589    estado    TABLE     y   CREATE TABLE public.estado (
    id integer NOT NULL,
    sigla character varying(2),
    nome character varying(100)
);
    DROP TABLE public.estado;
       public         heap    postgres    false            �            1259    16587    estado_id_seq    SEQUENCE     �   CREATE SEQUENCE public.estado_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.estado_id_seq;
       public          postgres    false    203                        0    0    estado_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.estado_id_seq OWNED BY public.estado.id;
          public          postgres    false    202            �            1259    16610    produto    TABLE     �   CREATE TABLE public.produto (
    id integer NOT NULL,
    nome character varying(255) NOT NULL,
    preco numeric(10,2) NOT NULL,
    quantidade integer NOT NULL
);
    DROP TABLE public.produto;
       public         heap    postgres    false            �            1259    16608    produto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.produto_id_seq;
       public          postgres    false    207            !           0    0    produto_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;
          public          postgres    false    206            �
           2604    16600 	   cidade id    DEFAULT     f   ALTER TABLE ONLY public.cidade ALTER COLUMN id SET DEFAULT nextval('public.cidade_id_seq'::regclass);
 8   ALTER TABLE public.cidade ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            �
           2604    16592 	   estado id    DEFAULT     f   ALTER TABLE ONLY public.estado ALTER COLUMN id SET DEFAULT nextval('public.estado_id_seq'::regclass);
 8   ALTER TABLE public.estado ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            �
           2604    16613 
   produto id    DEFAULT     h   ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);
 9   ALTER TABLE public.produto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206    207                      0    16597    cidade 
   TABLE DATA           5   COPY public.cidade (id, nome, estado_id) FROM stdin;
    public          postgres    false    205   6                 0    16589    estado 
   TABLE DATA           1   COPY public.estado (id, sigla, nome) FROM stdin;
    public          postgres    false    203   �                 0    16610    produto 
   TABLE DATA           >   COPY public.produto (id, nome, preco, quantidade) FROM stdin;
    public          postgres    false    207   �       "           0    0    cidade_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.cidade_id_seq', 3, true);
          public          postgres    false    204            #           0    0    estado_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.estado_id_seq', 27, true);
          public          postgres    false    202            $           0    0    produto_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.produto_id_seq', 8, true);
          public          postgres    false    206            �
           2606    16602    cidade cidade_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cidade DROP CONSTRAINT cidade_pkey;
       public            postgres    false    205            �
           2606    16594    estado estado_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.estado DROP CONSTRAINT estado_pkey;
       public            postgres    false    203            �
           2606    16615    produto produto_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public            postgres    false    207            �
           2606    16603    cidade cidade_estado_id_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.cidade
    ADD CONSTRAINT cidade_estado_id_fkey FOREIGN KEY (estado_id) REFERENCES public.estado(id);
 F   ALTER TABLE ONLY public.cidade DROP CONSTRAINT cidade_estado_id_fkey;
       public          postgres    false    203    205    2703               Q   x�3�(J-�LI�+IUK�KN-�I,�42�2�t>�+31)Q! �4'��$$j��_��P���W����ih����� �1�         B  x�]P�n�0<�~E�����MQQS,�c/D`	l�K���[� ?��������xt�O��o�g>Fnim�/|��h]�g�L��X��3�P�(N�4�r��o�付��C��L�(�������EzA�A}�Ւ�֨9q8�ߑ�B�,�U�m+L���e����I�QW����*q�rm�a��f1���wLjc0���iR����g�WϷ�N�v�Ū���"�#��Y�$�{L��`�?e����O���1�,Q/�&p�F8+��$�|
gउ���,�3��IG�9�l�^^�����[\��         {   x�%�1�0Cg�0���&�0S����PC*u@������';b���~�B�Ą�5bHN���d��׆�P2w&'�.Hp'�p��-O*�����ͫU,�����%���h{/^����     