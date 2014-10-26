from django.contrib.auth.models import User
from django.db import models

class Projeto(models.Model):
	projeto_id = models.AutoField(primary_key=True)
	nome = models.CharField(max_length=100)
	def __unicode__(self):
		return self.nome

class Categoria(models.Model):
	categoria_id = models.AutoField(primary_key=True)
	nome = models.CharField(max_length=100)
	def __unicode__(self):
		return self.nome

class Pergunta(models.Model):
	pergunta_id = models.AutoField(primary_key=True)
	enunciado = models.CharField(max_length=255)
	categoria = models.ForeignKey(Categoria)
	def __unicode__(self):
		return self.enunciado

class Questionario(models.Model):
	questionario_id = models.AutoField(primary_key=True)
	nome = models.CharField(max_length=100)
	projeto_id = models.ForeignKey(Projeto)
	def __unicode__(self):
		return self.nome

class Resposta(models.Model):
	resposta_id = models.AutoField(primary_key=True)
	pergunta_id = models.ForeignKey(Pergunta)
	usuario_id = models.ForeignKey(User)
	valor_resposta = models.CharField(null=False,max_length=3)
	data_hora = models.DateTimeField()
	def __unicode__(self):
		return self.valor_resposta

class QuestionarioPergunta(models.Model):
	questionario_id = models.ForeignKey(Questionario)
	pergunta_id = models.ForeignKey(Pergunta)

